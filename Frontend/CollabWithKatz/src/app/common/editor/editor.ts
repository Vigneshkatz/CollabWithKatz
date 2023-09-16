export class Editor {
        id!: number;
        name!: string;
        email!: string;
        password!: string;
        age!: number;
        country!: string;
        gender!: string;
        experienceInYears!: number;
        profilePictureUrl!: string;
        phone!: string;
        portfolioLink!: string;
        profileCreatedAt!: Date;
        ProfileUpdatedAt!: Date;
        editorCertifications: EditorCertification[] = [];
        editorCommunicationLanguages: EditorCommunicationLanguage[] = [];
        editorPreferences: EditorPreferences[] = [];
        editorProjects: EditorProject[] = [];
        editorSampleVideos: EditorSampleVideo[] = [];
        editorSocialMedia: EditorSocialMedia[] = [];
        editorSkills: EditorSkill[] = [];
}

export class EditorCertification {
        id!:number;
        certificationName!:string;
        certificationLink!:string;
}

export class EditorCommunicationLanguage {
        id!: number;
        language!: string;
        languageProficiency!: number;
}

export class EditorPreferences {
        id!: number;
        projectPreferences!: string;
}

export class EditorProject {
        id!: number;
        projectName!: string;
        projectStatus!: boolean;
}

export class EditorSampleVideo {
        id!: number;
        videoName!: string;
        videoLink!: string;
}

export class EditorSocialMedia {
        id!: number;
        platform!: string;
        platformLink!: string;
}

export class EditorSkill {
        id!:number;
        aboutSkill!:string;
        availability!:string;
        flexibility!:string;
        technicalProficiency!:string;
        equipmentDetails!:string;
}
