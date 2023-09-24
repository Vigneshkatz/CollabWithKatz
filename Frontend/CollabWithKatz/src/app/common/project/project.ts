
import { Injectable } from '@angular/core';

@Injectable()
export class Project {
    id!: number;
    creatorId!: number;
    editorId!: number; 
    projectName!: string;
    projectDescription!: string;
    rawVideoURl!: string;
  
}
