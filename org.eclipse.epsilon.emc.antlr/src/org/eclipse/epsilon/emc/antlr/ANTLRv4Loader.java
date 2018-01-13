package org.eclipse.epsilon.emc.antlr;

import org.antlr.parser.antlr4.ANTLRv4Parser;
import org.antlr.parser.antlr4.ANTLRv4ParserVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ANTLRv4Loader implements ANTLRv4ParserVisitor<Void> {
	
	private final AntlrModel model;
	
	public ANTLRv4Loader(AntlrModel model) {
		super();
		this.model = model;
	}

	@Override
	public Void visit(ParseTree tree) {
		return tree.accept(this);
	}
	
	@Override public Void visitAction(ANTLRv4Parser.ActionContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }
	
	@Override public Void visitActionBlock(ANTLRv4Parser.ActionBlockContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }
    
	@Override public Void visitActionScopeName(ANTLRv4Parser.ActionScopeNameContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }

	
	@Override public Void visitAlternative(ANTLRv4Parser.AlternativeContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitAltList(ANTLRv4Parser.AltListContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitArgActionBlock(ANTLRv4Parser.ArgActionBlockContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitAtom(ANTLRv4Parser.AtomContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitBlock(ANTLRv4Parser.BlockContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitBlockSet(ANTLRv4Parser.BlockSetContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitBlockSuffix(ANTLRv4Parser.BlockSuffixContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitChannelsSpec(ANTLRv4Parser.ChannelsSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitCharacterRange(ANTLRv4Parser.CharacterRangeContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }
	@Override
	public Void visitChildren(RuleNode node) {
		int n = node.getChildCount();
		for (int i=0; i<n; i++) {
			ParseTree c = node.getChild(i);
			c.accept(this);			
		}
		return null;
	}


	@Override public Void visitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitEbnf(ANTLRv4Parser.EbnfContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitElement(ANTLRv4Parser.ElementContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitElementOption(ANTLRv4Parser.ElementOptionContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitElementOptions(ANTLRv4Parser.ElementOptionsContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitExceptionGroup(ANTLRv4Parser.ExceptionGroupContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitExceptionHandler(ANTLRv4Parser.ExceptionHandlerContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitFinallyClause(ANTLRv4Parser.FinallyClauseContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }
	
	@Override
	public Void visitGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx) { 
		model.addModelElement(ctx);
		return visitChildren(ctx);
	}
	
	@Override
	public Void visitGrammarType(ANTLRv4Parser.GrammarTypeContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitIdentifier(ANTLRv4Parser.IdentifierContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitIdList(ANTLRv4Parser.IdListContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }

	@Override public Void visitLabeledAlt(ANTLRv4Parser.LabeledAltContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }

	@Override public Void visitLabeledElement(ANTLRv4Parser.LabeledElementContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLabeledLexerElement(ANTLRv4Parser.LabeledLexerElementContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerAlt(ANTLRv4Parser.LexerAltContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerAltList(ANTLRv4Parser.LexerAltListContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerAtom(ANTLRv4Parser.LexerAtomContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerBlock(ANTLRv4Parser.LexerBlockContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerCommand(ANTLRv4Parser.LexerCommandContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerCommandName(ANTLRv4Parser.LexerCommandNameContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerCommands(ANTLRv4Parser.LexerCommandsContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerElement(ANTLRv4Parser.LexerElementContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerElements(ANTLRv4Parser.LexerElementsContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitLocalsSpec(ANTLRv4Parser.LocalsSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitModeSpec(ANTLRv4Parser.ModeSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitNotSet(ANTLRv4Parser.NotSetContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitOption(ANTLRv4Parser.OptionContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitOptionsSpec(ANTLRv4Parser.OptionsSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitOptionValue(ANTLRv4Parser.OptionValueContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitPrequelConstruct(ANTLRv4Parser.PrequelConstructContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleAction(ANTLRv4Parser.RuleActionContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleAltList(ANTLRv4Parser.RuleAltListContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleBlock(ANTLRv4Parser.RuleBlockContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleModifier(ANTLRv4Parser.RuleModifierContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleModifiers(ANTLRv4Parser.RuleModifiersContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRulePrequel(ANTLRv4Parser.RulePrequelContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleref(ANTLRv4Parser.RulerefContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleReturns(ANTLRv4Parser.RuleReturnsContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRules(ANTLRv4Parser.RulesContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitRuleSpec(ANTLRv4Parser.RuleSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitSetElement(ANTLRv4Parser.SetElementContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitTerminal(ANTLRv4Parser.TerminalContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitThrowsSpec(ANTLRv4Parser.ThrowsSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }


	@Override public Void visitTokensSpec(ANTLRv4Parser.TokensSpecContext ctx) {
        model.addModelElement(ctx);
        return visitChildren(ctx);
    }

	@Override
	public Void visitTerminal(TerminalNode node) {
		// Terminal Nodes are not stored... do we need them?
		return null;
	}

	@Override
	public Void visitErrorNode(ErrorNode node) {
		// TODO Implement ParseTreeVisitor<Void>.visitErrorNode
		throw new UnsupportedOperationException("Unimplemented Method    ParseTreeVisitor<Void>.visitErrorNode invoked.");
	}

}
