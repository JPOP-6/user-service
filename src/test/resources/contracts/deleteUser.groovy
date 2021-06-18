package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Delete user"
    request {
        method DELETE()
        url("/users/1")
    }
    response {
        status OK()
        body(file("deleteUserResponse.json"))
    }
}