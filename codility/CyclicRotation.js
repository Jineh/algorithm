function solution(A, K) {
    K = (K > A.length) ? (K % A.length) : K;
    return A.splice(-K, K).concat(A);
}