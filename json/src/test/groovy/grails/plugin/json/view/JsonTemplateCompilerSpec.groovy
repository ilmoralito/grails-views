package grails.plugin.json.view

import grails.views.GenericGroovyTemplateResolver
import spock.lang.Specification

/**
 * Created by graemerocher on 24/08/15.
 */
class JsonTemplateCompilerSpec extends Specification {

    void "Test JsonTemplateCompiler compiles templates correctly"() {
        given:"A compiler instance"
        def view = new File(JsonTemplateCompilerSpec.getResource("/views/bar.gson").file)
        def compiler = new JsonViewCompiler(new JsonViewConfiguration(packageName:"test" ) , view.parentFile)

        def dir = File.createTempDir()
        dir.deleteOnExit()
        compiler.setTargetDirectory(dir)
        def resolver = new GenericGroovyTemplateResolver()
        resolver.classLoader = new URLClassLoader([dir.toURL()] as URL[])
        def engine = new JsonViewTemplateEngine()
        engine.templateResolver = resolver
        engine.packageName = "test"


        when:"templates are compiled"

        compiler.compile(view)

        then:"The template can be loaded"
        engine.resolveTemplate("/bar.gson") != null
    }
}
