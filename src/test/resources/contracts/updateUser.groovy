package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Update user"
    request {
        method PUT()
        headers {
            contentType(applicationJson())
        }
        body(file("addUserRequest.json"))
        url("/users/1")
    }
    response {
        status OK()
        body(file("addUserResponse.json"))
    }
}