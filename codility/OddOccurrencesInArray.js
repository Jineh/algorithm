
function solution(A) {  
    const totalCounter = A.reduce((counter, num) => {      counter[num] = counter[num] ? counter[num] + 1 : 1;      return counter;  }, {}); 
    console.log(totalCounter);
    console.log(typeof(totalCounter));
    for (key in totalCounter) {
        if (totalCounter[key] % 2 === 1) {
            return Number(key);      
        }  
        
    }
}


let b = [1,1,3,5,3,5,7,9,9];
console.log(solution(b));