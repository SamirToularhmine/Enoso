grammar WhileLanguage;

program : Program Identifier? declaration* Begin lDeclVariables statements End;
declaration : Proc Identifier OpeningParenthesis lDeclIdent (Coma Res type Identifier)ClosingParenthesis Begin statements End;
lDeclIdent : type Identifier (Coma type Identifier)*;
lDeclVariables : declVariables lDeclVariables*;
declVariables : type lIdentifier Semicolon ;
lIdentifier : Identifier (Coma Identifier)*;
type : Type | Table;
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
        | constant
        | aexpression opa aexpression
        | Minus aexpression
        | OpeningParenthesis aexpression ClosingParenthesis
        | Identifier OpeningBracket aexpression ClosingBracket
        | New Type OpeningBracket aexpression ClosingBracket
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
constant: (Minus)? Pos;

Pos : [0-9]+;
New : 'new';

Skip : 'skip';

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
OpeningBracket : '[' ;
ClosingBracket : ']';

Coma : ',';
Semicolon : ';';
Affectation : ':=';

Program : 'program';
Proc : 'proc';
Begin : 'begin';
End : 'end';
Res : 'res';
Call : 'call';


If : 'if';
Then : 'then';
Else : 'else';
While : 'while';
Do : 'do';

Type : Boolean | Int ;
Table : Type OpeningBracket ClosingBracket ;

Boolean : 'boolean';
Int : 'int';


Identifier : [a-z][a-z0-9_]*;

WS: [ \t\r\n]+ -> skip;


