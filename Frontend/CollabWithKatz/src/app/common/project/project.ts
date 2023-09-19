
import { Injectable } from '@angular/core';

@Injectable()
export class Project {
    projectId!: number;
    projectName!: string;
    projectDescription!: string;
    rawVideoURl!: string;
    editedVideoURL!: string;
    creatorId!: number;
    editorId!: number;   
}