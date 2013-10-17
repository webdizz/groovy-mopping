package name.webdizz.groovy.mopping.ast.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.codehaus.groovy.transform.GroovyASTTransformationClass;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
@GroovyASTTransformationClass("name.webdizz.groovy.mopping.ast.transformation.TransactionableTransformer")
public @interface Transactionable {

}
