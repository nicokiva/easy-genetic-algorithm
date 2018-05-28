
Set WshShell = WScript.CreateObject("WScript.Shell")

LinkName = WScript.Arguments(0)
LinkTargetPath = WScript.Arguments(1)

LinkFilename = "\" + LinkName + ".lnk"

strDesktop = WshShell.SpecialFolders("Desktop")
Set LNKFile = WshShell.CreateShortcut(strDesktop + "\" + LinkFilename)

LNKFile.TargetPath = LinkTargetPath
LNKFile.Arguments = ""
LNKFile.IconLocation = "C:\EGA\system\res\EGA.ico"
LNKFile.Description = "Easy Genetic Algorithms"
LNKFile.HotKey = ""
LNKFile.WindowStyle = "1"
LNKFile.WorkingDirectory = "C:\EGA"
LNKFile.Save
Set WshShell = NOTHING
Set LNKFile = NOTHING