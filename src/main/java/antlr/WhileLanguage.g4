grammar WhileLanguage;

program : Program Identifier? declaration* Begin lDeclVariables statements End;
declaration : Proc Identifier OpeningParenthesis lDeclIdent (Coma Res type Identifier)ClosingParenthesis Begin statements End;
lDeclIdent : type Identifier (Coma type Identifier)*;
lDeclVariables : declVariables lDeclVariables*;
declVariables : type lIdentifier Semicolon ;
lIdentifier : Identifier (Coma Identifier)*;
type : Type                                                                    #TypeType
        | Table                                                                #TypeTable
        ;
block : statement                                                              #BlockStatement
        | OpeningParenthesis statements ClosingParenthesis                     #BlockWithinParenthesis
        ;
statements : statement ( Semicolon statements )*;

statement : Skip                                                               #StatementSkip
        | Identifier Affectation aexpression                                   #StatementAffectation
        | If bexpression Then block ( Else block ) ?                           #StatementIf
        | While bexpression Do block                                           #StatementWhile
        | Call Identifier OpeningParenthesis lAexpression ClosingParenthesis   #StatementCall
        ;
lAexpression : aexpression (Coma aexpression)*;

aexpression : Identifier                                                       #AexpressionIdentifier
        | constant                                                             #AexpressionConstant
        | aexpression opa aexpression                                          #AexpressionBinary
        | Minus aexpression                                                    #AexpressionUnary
        | OpeningParenthesis aexpression ClosingParenthesis                    #AexpressionParenthesis
        | Identifier OpeningBracket aexpression ClosingBracket                 #AexpressionArray
        | New Type OpeningBracket aexpression ClosingBracket                   #AexpressionNew
        ;

opa : Plus                                                                     #OpaPlus
        | Minus                                                                #OpaMinus
        | Multiplication                                                       #OpaMultiplication
        | Division                                                             #OpaDivision
        ;
bexpression : True                                                             #BexpressionTrue
        | False                                                                #BexpressionFalse
        | aexpression opr aexpression                                          #BexpressionAexpressionOprAexpression
        | Not bexpression                                                      #BexpressionNot
        | OpeningParenthesis bexpression ClosingParenthesis                    #BexpressionParenthesis
        ;

opr : Lower                                                                    #OprLower
        | LowerOrEqual                                                         #OprLowerOrEqual
        | Greater                                                              #OprGreater
        | GreaterOrEqual                                                       #OprGreaterOrEqual
        | Equal                                                                #OprEqual
        | Different                                                            #OprDifferent
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


