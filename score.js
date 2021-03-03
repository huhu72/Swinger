//so far itll calculate total for players for a single hole
let total = 0;

function score(par, strokes) {
  if (strokes > 0) {
    let total = strokes - par;
    return total;
  } else {
    console.log('enter in strokes');
  }
}

console.log(score(3,2));
 console.log(score(3,4));
 console.log(score(3,1));
 console.log(score(3,7));
