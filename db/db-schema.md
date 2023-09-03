# DB structure

## Editor Schema

### Profile
- **id**: Unique identifier for the editor (Auto-incrementing integer)
- **name**: Editor's full name (String, required)
- **email**: Editor's email address (String, required, unique)
- **password**: Editor's password (String, required, hashed for security)
- **age**: Editor's age (Integer)
- **experience_years**: Years of editing experience (Integer)
- **social_media_link**: Link to the editor's social media profile (String)
- **country**: Editor's country (String)
- **gender**: Editor's gender (Enumeration: 'Male', 'Female', 'Other')
- **video_links**: List of video links or references to the editor's work (Array of Strings)
- **profile_picture**: URL or reference to the editor's profile picture (String)

### Contact Information
- **phone**: Editor's contact phone number (String)
- **address**: Editor's physical address (String or JSON)

### Skills
- **editing_skills**: Editor's skills and expertise (Text)
- **availability**: Editor's availability for projects (Text)
- **communication_languages**: Languages the editor is proficient in (Array of Strings)
- **flexibility**: Editor's flexibility and adaptability (Text)
- **technical_proficiency**: Editor's technical proficiency (Text)
- **equipment_details**: Details about the editor's equipment (Text)

### Timestamps
- **created_at**: Timestamp for when the editor's profile was created (Timestamp)
- **updated_at**: Timestamp for when the editor's profile was last updated (Timestamp)

### Collaborations Section
- **creator_comments**: Comments and feedback from creators (Text)
- **no_of_collabs**: Number of collaborations with creators (Integer)
- **likes**: Number of likes received on edited work (Integer)
- **endorsements**: Number of endorsements from creators (Integer)


### Payment Information
- **payment_details**: Editor's payment details for receiving payments (Text or JSON)

### Portfolio
- **portfolio_links**: Links to the editor's portfolio or sample work (Array of Strings)

### Education
- **education_details**: Details about the editor's educational background (Text)

### Certifications
- **certifications**: Editor's professional certifications or training (Text)

### Projects
- **active_projects**: List of currently active projects the editor is working on (Array of JSON)
- **completed_projects**: List of completed projects with details (Array of JSON)

### Preferences
- **project_preferences**: Editor's preferences for project types and genres (Text or JSON)

## Creator schema
