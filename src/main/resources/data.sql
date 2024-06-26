-- Inserting roles
INSERT INTO role (role_name)
VALUES ('ROL_ADMIN');

INSERT INTO role (role_name)
VALUES ('ROL_USER');

-- Inserting tags with potential null user_id
INSERT INTO tag (label_color, name, user_id)
VALUES ('#C73659', 'Personal', NULL);

INSERT INTO tag (label_color, name, user_id)
VALUES ('#77B0AA', 'Chores', NULL);

INSERT INTO tag (label_color, name, user_id)
VALUES ('#FFD0D0', 'Study', NULL);

-- Insert into badge table
INSERT INTO badge (badge_name, default_text, streak_connection, num_tasks_done)
VALUES ('BRONZE', 'Let the spark of inspiration ignite your focus, fuel your productivity, and guide you to accomplish your tasks with unwavering determination.', 0, 0);

INSERT INTO badge (badge_name, default_text, streak_connection, num_tasks_done)
VALUES (
           'GOLD',
           'Congratulations on reaching the GOLD level with an incredible 50-day streak! Your dedication and hard work are truly impressive. This milestone is a testament to your commitment and perseverance. Keep up the fantastic work, and continue to shine brightly!',
           20,
           50
       );

INSERT INTO badge (badge_name, default_text, streak_connection, num_tasks_done)
VALUES (
           'PLATINUM',
           'Amazing achievement! You have unlocked the PLATINUM level with a remarkable 150-day streak. Your unwavering commitment and determination set a new standard of excellence. This is a moment to celebrate your outstanding effort and relentless pursuit of your goals. Keep pushing forward!',
           40,
           150
       );

INSERT INTO badge (badge_name, default_text, streak_connection, num_tasks_done)
VALUES (
           'DIAMOND',
           'Incredible accomplishment! You have reached the DIAMOND level with an astonishing 250-day streak. Your perseverance and dedication are truly inspiring, shining brightly for all to see. This milestone reflects your extraordinary effort and unyielding spirit. Keep striving for greatness!',
           60,
           250
       );

INSERT INTO badge (badge_name, default_text, streak_connection, num_tasks_done)
VALUES (
           'MASTER',
           'Outstanding performance! You have attained the MASTER level with an impressive 350-day streak. Your expertise, consistency, and unwavering focus are unparalleled. This remarkable achievement is a testament to your relentless pursuit of excellence. Continue to lead by example and inspire others!',
           90,
           350
       );

INSERT INTO badge (badge_name, default_text, streak_connection, num_tasks_done)
VALUES (
           'CHALLENGER',
           'Unbelievable success! You have reached the CHALLENGER level with a phenomenal 360-day streak. Your relentless pursuit of excellence and indomitable spirit are truly inspiring. This extraordinary milestone showcases your dedication and passion. Keep challenging yourself and reaching new heights!',
           360,
           500
       );

-- Insert into theme table
INSERT INTO theme (primary_color, secondary_color)
VALUES ('#AD88C6', '#AD88C6');

INSERT INTO theme (primary_color, secondary_color)
VALUES ('#7AB2B2', '#4D869C');

INSERT INTO theme (primary_color, secondary_color)
VALUES ('#D1BB9E', '#A79277');