rootProject.name = "ecommerce"

include("backoffice", "shared")

project(":backoffice").projectDir = file("src/backoffice")
project(":shared").projectDir = file("src/shared")
