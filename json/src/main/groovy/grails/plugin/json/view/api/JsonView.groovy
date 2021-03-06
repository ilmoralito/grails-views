package grails.plugin.json.view.api

import grails.artefact.Enhances
import grails.plugin.json.view.JsonViewTemplate
import grails.plugin.json.view.api.internal.JsonGrailsViewHelper
import grails.plugin.json.view.api.internal.TemplateNamespaceInvoker
import grails.views.Views
import grails.views.api.GrailsView

/**
 * Extends default view API with additional methods
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@Enhances(JsonViewTemplate.TYPE)
trait JsonView extends GrailsView {

    /**
     * Overrides the default helper with new methods specific to JSON building
     */
    private GrailsJsonViewHelper viewHelper = new JsonGrailsViewHelper(this)

    /**
     * @return The default view helper
     */
    @Override
    GrailsJsonViewHelper getG() {
        return viewHelper
    }

    /**
     * The template namespace
     */
    TemplateNamespaceInvoker tmpl = new TemplateNamespaceInvoker(viewHelper)
}