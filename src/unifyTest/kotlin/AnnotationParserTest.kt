import lib.matcher.TestableStatic
import unify.parsers.functions.FunctionParser
import unify.parsers.headers.AnnotationDeclarationParser
import unify.parsers.headers.AnnotationParser
import kotlin.test.Test

class AnnotationParserTest : ParserTest() {

    override var parser: TestableStatic<String> = AnnotationParser()

    override val fileDir = "directives/annotations/"


    @Test
    fun `Simplest Annotation`() {
        file = "SimplestAnnotation"
    }

    @Test
    fun `Simple Annotation`() {
        file = "SimpleAnnotation"
    }

    @Test
    fun ComplexAnnotation() {
        file = "ComplexAnnotation"
    }

    @Test
    fun `Annotation Declaration`() {
        parser = AnnotationDeclarationParser()
        file = "AnnotationDeclaration"
    }


    @Test
    fun `Simple Generic Annotation Declaration`() {
        parser = AnnotationDeclarationParser()
        file = "SimpleGenericAnnotationDeclaration"
    }

    @Test
    fun `Simplest Generic Annotation Declaration`() {
        parser = AnnotationDeclarationParser()
        file = "SimplestGenericAnnotationDeclaration"
    }

    @Test
    fun `Complex Generic Annotation Declaration`() {
        parser = AnnotationDeclarationParser()
        file = "ComplexGenericAnnotationDeclaration"
    }

    @Test
    fun `Annotations with generic classes`() {
        file = "GenericAnnotation"
    }

    @Test
    fun `Annotated Function`() {
        parser = FunctionParser()
        file = "AnnotatedFunction"
    }

}