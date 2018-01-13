package org.eclipse.epsilon.emc.antlr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.antlr.parser.antlr4.ANTLRv4Lexer;
import org.antlr.parser.antlr4.ANTLRv4Parser;
import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An IModel implementation to work with antlr grammars.
 * 
 * The model provides a perType access to the parser tree. ExL programs can access the tree element properties via the
 * method name (this model uses the JavaPropertyGetter).
 * 
 * @author Horacio Hoyos Rodriguez
 *
 */
public class AntlrModel extends CachedModel<RuleContext> implements IModel  {

	public static final String PROPERTY_PATH = "path";
	private String file_path;
	private GrammarSpecContext tree;
	private ANTLRv4Parser antlrParser;
	private List<Collection<RuleContext>> elementsPerType = new ArrayList<Collection<RuleContext>>(ANTLRv4Parser.ruleNames.length);
	private Logger logger = LoggerFactory.getLogger(AntlrModel.class);
	private static final Set<String> KNOWN_TYPES = new HashSet<String>(Arrays.asList(ANTLRv4Parser.ruleNames));
	
	
	public AntlrModel() {
		for(int i=0;i<ANTLRv4Parser.ruleNames.length;i++) {
			elementsPerType.add(new ArrayList<>());
		}
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException("Enumerations not supported.");
	}

	@Override
	public String getTypeNameOf(Object instance) {
		if (instance instanceof RuleContext) {
			return ANTLRv4Parser.ruleNames[((RuleContext)instance).getRuleIndex()];
		}
		return instance.getClass().getName();
	}

	@Override
	public Object getElementById(String id) {
		throw new UnsupportedOperationException("Antlr modes does not support element ids.");
	}

	@Override
	public String getElementId(Object instance) {
		throw new UnsupportedOperationException("Antlr modes does not support element ids.");
	}

	@Override
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException("Antlr modes does not support element ids.");
	}

	@Override
	public boolean owns(Object instance) {
		// FIXME This does a tree climb, so we dont have to look over all elmentsPerType
		if (instance instanceof ParserRuleContext) {
			RuleContext p = (RuleContext) instance;
			while ( p!=null ) {
				p = p.parent;
				if (p == tree) {
					return true;
				}
			}
			logger.debug("Reached root before matching this model's tree");
		}
		return false;
	}

	@Override
	public boolean isInstantiable(String type) {
		logger.debug(String.format("Called isInstantiable for %s.", type));
		return false;
	}

	@Override
	public boolean hasType(String type) {
		return KNOWN_TYPES.contains(type);
	}

	@Override
	public boolean store(String location) {
		logger.debug(String.format("Call to store(%s) will be ignored as model is read-only.", location));
		return false;
	}

	@Override
	public boolean store() {
		logger.debug("Call to store will be ignored as model is read-only.");
		return false;
	}
	

	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		// TODO Auto-generated method stub
		super.load(properties, resolver);
		file_path = resolver.resolve(properties.getProperty(PROPERTY_PATH));
		load();
	}
	
	
	public ANTLRv4Parser getAntlrParser() {
		return antlrParser;
	}


	@Override
	protected Collection<RuleContext> allContentsFromModel() {
		return null;
	}

	@Override
	protected Collection<RuleContext> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		if (hasType(type)) {
			int index = IntStream.range(0, KNOWN_TYPES.size())
					.filter(i -> ANTLRv4Parser.ruleNames[i].equals(type))
				    .findFirst()
				    .getAsInt();
			return elementsPerType.get(index);
		}
		return Collections.emptyList();
	}

	@Override
	protected Collection<RuleContext> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		return getAllOfTypeFromModel(kind);
	}

	@Override
	protected RuleContext createInstanceInModel(String type) {
		throw new UnsupportedOperationException("New instance creation is not supported.");
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		ANTLRv4Lexer lexer;
		try {
			lexer = new ANTLRv4Lexer(CharStreams.fromFileName(file_path));
		} catch (IOException e) {
			throw new EolModelLoadingException(e, this);
		}
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		antlrParser = new ANTLRv4Parser(tokenStream);
		tree = antlrParser.grammarSpec();
		ANTLRv4Loader loader = new ANTLRv4Loader(this);
		tree.accept(loader);
	}

	@Override
	protected void disposeModel() {
		tree = null;
		antlrParser = null;
		elementsPerType.clear();
	}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		throw new UnsupportedOperationException("Deletion is not supported.");
	}

	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		return Arrays.asList(new String[]{getTypeNameOf(instance)});
	}
	
	protected boolean addModelElement(RuleContext element) {
		Collection<RuleContext> elements = elementsPerType.get(element.getRuleIndex());
//		if (elements == null) {
//			elements = new ArrayList<>();
//			elementsPerType.add(element.getRuleIndex(), elements);
//		}
		return elements.add(element);
	}

}
