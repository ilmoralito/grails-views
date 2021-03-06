package grails.plugin.json.view.api.internal

import grails.plugin.json.view.api.GrailsJsonViewHelper

/**
 * Handles the template namespace
 *
 * @author Graeme Rocher
 * @since 1.0
 */
class TemplateNamespaceInvoker {

    final GrailsJsonViewHelper jsonViewHelper

    TemplateNamespaceInvoker(GrailsJsonViewHelper jsonViewHelper) {
        this.jsonViewHelper = jsonViewHelper
    }

    @Override
    Object invokeMethod(String name, Object args) {
        Object[] argArray = (Object[]) args

        def len = argArray.length
        if(len == 1) {
            def val = argArray[0]
            if(val instanceof Map) {
                return jsonViewHelper.render(template:name, model:val)
            }
            else if(val instanceof Iterable) {
                return jsonViewHelper.render(template:name, var:name, collection:val)
            }
            else {
                return jsonViewHelper.render(template:name, model:[(name): val])
            }
        }
        else if(len == 2) {
            def var = argArray[0]
            def coll = argArray[1]
            if(coll instanceof Collection) {
                return jsonViewHelper.render(template:name, var:var.toString(), collection:coll)
            }
        }

    }
}
