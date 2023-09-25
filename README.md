This repository contains:
* `adups_search_updates.py`: A script that can search for new updates. It can only detect updates if RO_FOTA_VERSION is set to a recent version; if it's old, the update won't be detected.
* `original_apk`: The decompiled original APK that searches for updates on the stock ROM.
* `project`: A Java project with code grabbed from the original APK. It can generate the data sent in the POST request to search for updates. This should no longer be needed, use the Python script.