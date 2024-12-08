# picknpic
SE practices project

# Using git
## Rules
1 - do **not** apply any changes in the code on the main branch, always code on another branch\
2 - on the first pull (git clone), change branch immediately **before** coding (as per rule 1)\
3 - your branch name must reflect the functionality you're working on : it must be **clear**\
4 - as soon as your functionality is finished and **rigorously tested**, make a pull request to main to incorporate it\
5 - once the branch is merged, go back to rule 2

## How to properly commit
Your commit messsage should strictly follow these principles\
**For added functionalities :** "feat : <brief and clear description>"\
**For modified/fixed functionalities :** "fix : <brief and clear description>"\
**If there currently are bugs in the code :** "bug/issues : <clear description>"

## Reminder of basic git commands
**Create a branch :** git checkout -b <branch name>\
**Change branch :** git checkout <branch name>\
**First push of a branch :** git push --set-upstream origin <branch name>\
**Classic push :** \
git add .\
git commit -m "commit message (if unsure, see rules above)"\
git push

