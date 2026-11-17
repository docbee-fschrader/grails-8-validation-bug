package com.example
import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration

/**
 * See https://grails.apache.org/docs/latest/guide/testing.html#functionalTesting and https://groovy.apache.org/geb/manual/current/
 * for more instructions on how to write functional tests with Grails and Geb.
 */
@Integration
class DemoSpec extends ContainerGebSpec {

    void 'create domain without grails validation'() {
        when: 'create domain'
        Example.withNewTransaction {
            Example example = new Example()
            example.text = 'invalid' // this would fail grails validation
            example.save(validate: false)// skip grails validation (this works, grails validation is skipped)
        } // when the transaction is flushed the grails validation is executed and fails

        and: 'query count'
        int count = Example.withNewTransaction {
            Example.count()
        }

        then: 'domain was created'
        count == 1 // this fails, because the grails validation is executed on flush
    }
}
