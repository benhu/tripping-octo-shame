# Services
## REST
### Authentification
#### URL
`/rest/connect/{username}/{password}`

#### Annotations

#### Paramètres

### Commande
#### URL
`/rest/order/{reference}/{quantity}/{token}`

#### Annotations
Le produit référencé doit exister.

Soit Q la quantité du produit disponible en stock, et q la quantité commandée 
tels que 0 < q < Q.

Le token doit correspondre au token reçu lors de l'identification.

Si l'un des paramètres ne satisfait pas ses conditions, une erreur est envoyée.

#### Paramètres
* reference: référence produit
* quantity: quantité
* token: jeton d'authentification

## SOAP
### Liste des produits
#### URL
/services/product?wsdl

#### Annotations

#### Paramètres


# Architecture
## WSCompanyA
Service Provider.

### Packages
#### beans
##### Product
Représente un produit :
* référence
* quantité
* nom

##### User
Représente un utilisateur :
* id
* login
* mot de passe
* guid

#### controllers
##### REST
###### LoginController
S'occupe de l'authentification des utilisateurs.

###### OrderController
S'occupe de la gestion des commandes de produits.

##### SOAP
###### IProductController
Interface du contrôleur des produits (pour récupérer la liste des produits).
###### ProductController
Implémentation de l'interface.
Se charge de renvoyer la liste des produits disponibles.

#### models
##### Products
Singleton représentant les données, ie les produits disponibles.

##### Users
Singleton représentant les utilisateurs de l'application.

### Paramétrages

## WSCompanyB
Client application.

### Packages
##### User
Représente un utilisateur :
* id
* login
* mot de passe
* guid

##### Main
S'occupe de faire les appels à l'application publiant les services grâce à 
RestTemplate.

### Paramétrages
URL en dur.
