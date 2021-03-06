package grails.views.api

import grails.artefact.Enhances
import grails.views.Views

/**
 * @author Graeme Rocher
 */
@Enhances(Views.TYPE)
trait HttpView {

    /**
     * @return The page object
     */
    Page page

    static interface Page {

        /**
         * Set a response header
         *
         * @param name The name of the header
         * @param value The value of the header
         */
        void header(String name, String value)

        /**
         * Set a single named value header
         * @param nameAndValue The name and value. Example header(foo:"bar")
         */
        void header(Map<String,String> nameAndValue)

        /**
         * Set multiple headers
         *
         * @param namesAndValues The names and values
         */
        void headers(Map<String,String> namesAndValues)

        /**
         * Set the response content type
         *
         * @param contentType
         */
        void contentType(String contentType)

        /**
         * Sets the response encoding
         *
         * @param encoding
         */
        void encoding(String encoding)

        /**
         * Sets the response status
         *
         * @param status The status
         */
        void status(int status)

        /**
         * Sets the response status
         *
         * @param status The status
         */
        void status(int status, String message)
    }
}