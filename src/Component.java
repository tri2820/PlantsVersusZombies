/* Component consists of data and method
 * which evolves in an aspect of an entity*/

/* Methods could mutate the data in that component */

/* Methods should be called from a Systema
 * or other methods inside the component*/

/* Methods should be static
 *  and receives entities explicitly as arguments, should not use `this` */

/* Component could query other components from the receive entities as requirements */

/* Data should contains the state of entity in that aspect
 * or how a particular method performs */

/* Data should be assigned when create a child class of Entity (new entity type) */

class Component {
}