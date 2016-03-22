package expr;
 
/** Basic methods in a simple expression.
 * Only constants and four binary operations are implemented. 
 * Parentheses may be used witout any limitation.
 * 
 * Jan 2002   First version
 * 30.08.2002 redesigned
 * 23.12.2002 package
 * 07.04.2013 Simplified
 * 
 * @author M A Eyler
 */
 
public interface Expression {
   /** Returns float value of this Expression */    
   float fValue();
   /** String representation of this Expression */   
   String toString();
   /** Converts this Expression to postfix (RPN) */   
   String toPostfix();
   /** Converts this Expression to a tree */   
   String toTree();
}
