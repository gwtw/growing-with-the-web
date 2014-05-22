'use strict';

function bottomUpMergeSort(array) {
    var workArray = new Array(array.length);
    var chunkSize = 1;
    while (chunkSize < array.length) {
        var i = 0;
        while (i < array.length - chunkSize) {
            bottomUpMerge(array, i, chunkSize, workArray);
            i += chunkSize * 2;
        }
        chunkSize *= 2;
    }
    return array;
}

function bottomUpMerge(array, leftPosition, chunkSize, workArray) {
    var i;
    var rightPosition = leftPosition + chunkSize;
    var endPosition = Math.min(leftPosition + chunkSize * 2 - 1, array.length - 1);
    var leftIndex = leftPosition;
    var rightIndex = rightPosition;

    for (i = 0; i <= endPosition - leftPosition; i++) {
        if (leftIndex < rightPosition &&
                (rightIndex > endPosition ||
                array[leftIndex] <= array[rightIndex])) {
            workArray[i] = array[leftIndex++];
        } else {
            workArray[i] = array[rightIndex++];
        }
    }

    for (i = leftPosition; i <= endPosition; i++) {
        array[i] = workArray[i - leftPosition];
    }
}
