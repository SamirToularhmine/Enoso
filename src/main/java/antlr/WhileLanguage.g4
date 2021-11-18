grammar WhileLanguage;

program : Program (Identifier) declaration* Begin lDeclVariables statements End;
declaration : Proc Identifier OpeningParenthesis lDeclIdent (Coma Res type Identifier)ClosingParenthesis Begin statements End;
lDeclIdent : type Identifier (Coma type Identifier)*;
lDeclVariables : declVariables lDeclVariables*;
declVariables : type lIdentifier;
lIdentifier : Identifier (Coma Identifier)*;
type : Int | Boolean ;
block : statement
        | OpeningParenthesis statements ClosingParenthesis
        ;
statements : statement ( Semicolon statements )*;
statement : Skip
        | Identifier Affectation aexpression
        | If bexpression Then block ( Else block )
        | While bexpression Do block
        | Call Identifier OpeningParenthesis lAexpression ClosingParenthesis
        ;
lAexpression : aexpression (Coma aexpression)*;
aexpression : Identifier
        | Constant
        | aexpression opa aexpression
        | Minus aexpression
        | OpeningParenthesis aexpression ClosingParenthesis
        ;

opa : Plus
        | Minus
        | Multiplication
        | Division
        ;
bexpression : True
        | False
        | aexpression opr aexpression
        | Not bexpression
        | OpeningParenthesis bexpression ClosingParenthesis
        ;

opr : Lower
        | LowerOrEqual
        | Greater
        | GreaterOrEqual
        | Equal
        | Different
        ;
Identifier : [a-zA-Z_][a-zA-Z0-9_]*;
Constant: Pos
        | Neg
        ;
Pos : [0-9]+;
Neg : '-' Pos;

Plus : '+';
Minus : '-';
Multiplication : '*';
Division : '/';

True : 'true';
False : 'false';

Lower : '<';
LowerOrEqual : '<=';
Greater : '>';
GreaterOrEqual : '>=';
Equal : '=';
Different : '<>';

Not : 'not';
OpeningParenthesis : '(';
ClosingParenthesis : ')';

Coma : ',';
Semicolon : ';';
Affectation : ':=';

Program : 'program';
Proc : 'proc';
Begin : 'begin';
End : 'end';
Res : 'res';
Skip : 'skip';
Call : 'call';

If : 'if';
Then : 'then';
Else : 'else';
While : 'while';
Do : 'do';

Boolean : 'boolean';
Int : 'int';