'use strict';

function countingSort(array, maxValue) {
    var buckets = new Array(maxValue);
    var sortedIndex = 0;
    var i;

    // init array
    for (i = 0; i < buckets.length; i++)
        buckets[i] = 0;

    for (i = 0; i < array.length; i++)
        buckets[array[i]]++;

    for (i = 0; i < buckets.length; i++) {
        while (buckets[i] > 0) {
            array[sortedIndex++] = i;
            buckets[i]--;
        }
    }

    return array;
}
