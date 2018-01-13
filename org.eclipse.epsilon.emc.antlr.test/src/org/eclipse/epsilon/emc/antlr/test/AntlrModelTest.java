package org.eclipse.epsilon.emc.antlr.test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.antlr.AntlrModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class AntlrModelTest {

	@Test
	public void testLoadSingleModel() throws EolModelLoadingException, URISyntaxException {
		
		URL atlGrammar = AntlrModelTest.class.getResource("SampleLanguage.g4");
		Path path = Paths.get(atlGrammar.toURI());
		AntlrModel model = new AntlrModel();
		StringProperties properties = new StringProperties();
		properties.put(AntlrModel.PROPERTY_PATH, path.toAbsolutePath());
		model.load(properties);
		Collection<RuleContext> rules = null;
		try {
			rules = model.getAllOfType("parserRuleSpec");
		} catch (EolModelElementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (RuleContext t : rules) {
			if ( t instanceof ParserRuleSpecContext) {
				ParserRuleSpecContext r = (ParserRuleSpecContext)t;
		        System.out.println("Rule "  + r.RULE_REF());
		    }      
		    else { 
		        TerminalNode token = (TerminalNode)t;
		        //nodes.add(token.getText());
		        System.out.println("Token" + token.getText());
		    }      
		}
	}

}
