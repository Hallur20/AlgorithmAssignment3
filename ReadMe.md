<h1>made by: Hallur við Neyst / Murched Kayed / Mohammad Saad</h1>

<h2>We have pritoritized the passengers in these levels:</h2>
<ul>
  <li>LateForFlight 1</li>
  <li>Disabled 2</li>
  <li>BusinessClass 3</li>
  <li>Family 4</li>
  <li>Monkey 5</li>
</ul>

<h2>we decided to make our own method that checks the category of a passenger and returns it's priority:</h2>

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

<h2>our original choice for sorting the queue was the "max heap sort" because of it being the fastest in a non-unique list. However
  under the development we ran into some challenges as for example: swapping and finding the parent (we fixed it later but not fully, and this is where we decided to give up on the algorithm). We then moved on to insertition-sort, which was the next fastest algorithm in a non-unique list.
  </2>
