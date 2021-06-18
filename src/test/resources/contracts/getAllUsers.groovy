package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "return all users"
    request {
        method GET()
        url("/users/")
    }
    response {
        status OK()
        body(file("getAllUsersResponse.json"))
    }
}