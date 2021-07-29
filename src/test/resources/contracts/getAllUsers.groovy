package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "return all users"
    request {
        method GET()
        headers {
            contentType(applicationJson())
        }
        url("/users/")
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("getAllUsersResponse.json"))
    }
}