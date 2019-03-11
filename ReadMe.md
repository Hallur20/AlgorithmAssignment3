<h1>made by: Hallur við Neyst / Murched Kayed / Mohammad Saad</h1>

<h2>We have pritoritized the passengers in these levels:</h2>
<ul>
  <li>LateForFlight 1</li>
  <li>Disabled 2</li>
  <li>BusinessClass 3</li>
  <li>Family 4</li>
  <li>Monkey 5</li>
</ul>

<h2>we decided to make our own method that checks the category of a passenger and returns it's priority</h2>

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
