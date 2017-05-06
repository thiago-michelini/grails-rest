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
        Product.saveAll(
                new Product(name: 'Maça', price: 3.8),
                new Product(name: 'Laranja', price: 4.2),
                new Product(name: 'Banana', price: 2.65),
                new Product(name: 'Caki', price: 7.0)
        )
    }

    def cleanup() {
    }

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void "teste se a acao search localiza resultados"() {
        when: "eh executada uma consulta que localiza resultados"
        controller.search('ran', 10)

        then: "a resposta estah correta"
        response.json.size() == 1
        response.json[0].name == 'Laranja'
    }
}