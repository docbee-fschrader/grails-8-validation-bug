package com.example

class Example {

    String text

    static constraints = {
        text validator: { val, obj ->
            if (val == 'invalid') {
                return ['invalidText']
            }
        }
    }

    static mapping = {
        // explicit sequence id: Grails 8.0.0 cannot initialize the default native id on PostgreSQL
        // (fixed after the release in apache/grails-core#16582). A sequence id defers the INSERT to the flush.
        id generator: 'sequence', params: [sequence_name: 'example_seq']
    }
}
