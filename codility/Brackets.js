function solution(S) {
    if(S.length === 0) return 1;

    let arr = [];

    for(let i in S) {

        if (S[i]===')'){
            if(arr.pop()!=='('){
                return 0;
            }
        }

        else if (S[i]===']'){
            if(arr.pop()!=='['){
                return 0;
            }
            else{
                
            }
        }

        else if (S[i]==='}'){
            if(arr.pop()!=='{'){
                return 0;
            }
        }

        else {
            arr.push(S[i]);
        }
    }

    if(arr.length !== 0) return 0

    return 1;
}