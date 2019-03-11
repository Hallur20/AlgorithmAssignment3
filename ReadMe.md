<h1>Airport Queueing</h1>

<h1>passengers priorities</h1>
<h2>We have pritoritized the passengers in these levels:</h2>
<ul>
  <li>LateForFlight 1</li>
  <li>Disabled 2</li>
  <li>BusinessClass 3</li>
  <li>Family 4</li>
  <li>Monkey 5</li>
</ul>

<h1>How did we prioritize?</h1>

<p>We decided to make our own method that checks the category of a passenger instead of the comapareTo. The reason we have not
 used the compareTo in passenger.java is that we were unsure if we should make any changes in the package the file was located in.</p>

```java
@Override
    public int getPriority(Category category) {
        if (category == Category.Monkey) {
            return 5;
        }
        if (category == Category.Family) {
            return 4;
        }
        if (category == Category.BusinessClass) {
            return 3;
        }
        if (category == Category.Disabled) {
            return 2;
        }
        if (category == Category.LateToFlight) {
            return 1;
        }
        return 0;
    }
```
<h1>Algorithm choice</h1>
<p>We decided to use the "max heap sort" to start with, because it is the fastest way to sort an non-unique list. However
  under the development we ran into some challenges as for example: swapping and finding the parent (we fixed it later but not fully, and this is where we decided to give did not continued developing the "max heap sort" algorithm). That was the reason we moved on to the "insertition-sort" instead, which was the next fastest algorithm in a non-unique list.
  </p>
  
  <h1>Setup</h1>
  
  <p>we have hard-coded 50 random passengers in a list, which we then sort with our algorithm. The reason we have not used the template as much as we could have, is that we could not understand the system in areas such as: the tail of the queue, the head of the queue (we tried using these in our algorithm), the clock system etc.</p>
