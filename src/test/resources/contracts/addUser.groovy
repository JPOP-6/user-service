package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Add user"
    request {
        method POST()
        headers {
            contentType(applicationJson())
        }
        body(file("addUserRequest.json"))
        url("/users/")
    }
    response {
        status OK()
        body(file("addUserResponse.json"))
    }
}