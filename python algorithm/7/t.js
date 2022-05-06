function solution(lottos, win_nums) {
    var answer = [];
    crt=[0,6,5,4,3,2,1];
    tr=0;
    zero=0;
    for (var i=0; i<lottos.length; i++){
        
        if(win_nums.includes(lottos[i])){
            tr++;
        }
        else{
            if(lottos[i]==0){
                zero++;
                console.log("zero");
            }
        }
    }
    console.log(tr);
    var myMax=tr+zero;
    var myMin=tr;
    myMax = crt.indexOf(myMax,1);
    myMin = crt.indexOf(myMin,1);
    
    if (myMin==-1){
        myMin=6
    }
    answer.push(myMax);
    answer.push(myMin);
    
    return answer;
}

solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35])