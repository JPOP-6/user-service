package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "get user by Id"
    request {
        method GET()
        headers {
            contentType(applicationJson())
        }
        url("/users/1")
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("getUserByIdResponse.json"))
    }
}