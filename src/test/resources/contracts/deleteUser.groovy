package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Delete user"
    request {
        method DELETE()
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
        body(file("deleteUserResponse.json"))
    }
}