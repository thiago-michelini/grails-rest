package grails.rest

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(ProductController)
class ProductControllerSpec extends HibernateSpec {

    def setup() {
    }

    def cleanup() {
    }

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}