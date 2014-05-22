'use strict';

function insertionSort(array) {
    var i;
    for (i = 1; i < array.length; i++) {
        var item = array[i];
        var indexHole = i;
        while (indexHole > 0 && array[indexHole - 1] > item) {
            array[indexHole] = array[--indexHole];
        }
        array[indexHole] = item;
    }
    return array;
}
