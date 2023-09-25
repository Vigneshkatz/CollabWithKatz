export class Creator {
    id!:number;
    name!:string;
    email!:string;
    password!:string;
    upvoteList!:Upvote[];
    reviewList!:Review[];
}

export class Upvote{
    id!:number;
    isVoted!:boolean;
}

export class Review{
    id!:number;
    reviewDescription!:string;
}