package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "get user by Id"
    request {
        method GET()
        url("/users/1")
    }
    response {
        status OK()
        body(file("getUserByIdResponse.json"))
    }
}