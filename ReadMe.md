<h1>Airport Queueing</h1>

<h2>How did we prioritize?</h2>

<p>We decided to make our own method that checks the category of a passenger instead of the comapareTo. The reason we have not
used the compareTo in <a href="https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_09/Assignment_03/Airport_Queue_template/src/main/java/dk/cphbusiness/airport/template/Passenger.java">passenger.java </a> is that we were unsure if we should make any changes in the package the file was located in.</p>

<h3>Priorities:</h3>

 <table>
<thead>
<tr>
<th align="left"><strong>Passengers</strong></th>
<th align="center">LateForFlight</th>
<th align="center">Disabled</th>
<th align="center">BusinessClass</th>
<th align="center">Family</th>
  <th align="center">Monkey</th>
</tr>
</thead>
<tbody>
<tr>
<td align="left"><strong>Priority</strong></td>
<td align="center">1</td>
<td align="center">2</td>
<td align="center">3</td>
<td align="center">4</td>
 <td align="center">5</td>
</tr>
</tbody>
</table>

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
  under the development we ran into some challenges as for example: swapping and finding the parent (we fixed it later but not fully, and this is where we decided to give did not continued developing the "max heap sort" algorithm). That was the reason we moved on to the <a href="https://github.com/Hallur20/AlgorithmAssignment3/blob/master/NotPrioritisingPassengerArrayQueue.java">insertitionSort</a> instead, which was the next fastest algorithm in a non-unique list.
  </p>
  
  <h1>Setup</h1>
  
  <p>We have hard-coded 50 random passengers in a list, which we then sort with our algorithm. The reason we have not used the template as much as we could have, is that we could not understand the system in areas such as: the tail of the queue, the head of the queue (we tried using these in our algorithm), the clock system etc.</p>
