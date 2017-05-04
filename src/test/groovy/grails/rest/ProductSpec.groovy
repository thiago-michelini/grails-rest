package grails.rest

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends HibernateSpec {

    def setup() {
    }

    def cleanup() {
    }

    void 'teste de validacao de classe de dominio'() {
        when: 'uma classe de dominio eh salva com dados invalidos'
        Product product = new Product(name: null, price: -2.0d)
        product.save()

        then: 'houve erros e os dados nao foram salvos'
        product.hasErrors()
        product.errors.getFieldError('name')
        product.errors.getFieldError('price')
        Product.count() == 0

        when: 'um dominio valido eh salvado'
        product.name = 'Banana'
        product.price = 2.25d
        product.save()

        then: 'o produto foi salvo com sucesso'
        Product.count() == 1
        Product.first().price == 2.25d
    }
}
