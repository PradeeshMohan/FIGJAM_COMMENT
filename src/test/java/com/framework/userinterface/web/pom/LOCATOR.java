package com.framework.userinterface.web.pom;

public class LOCATOR {

    //  =========================================Login page locators=========================================
    public static final String LOGIN_BUTTON_TO_OPEN_FORM = "//a[@class='figma-19x2e0n']";
    public static final String USERNAME_FIELD = "//input[@name='email']";
    public static final String USER_PASSWORD = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//button[text()='Log in']";
    public static final String LOGIN_IFRAME_FORM = "//iframe[@class=\"css-17sxlh0\"]";

    // ======================================Home page locators===========================================
    public static final String TEAMS_BUTTON = "//span[@class='svg-container sidebar--expandCaret--jRGxN']";
    public static final String TEAMS_SELECTION = "(//div[contains(@class,'team_link--teamNameCustomSections--8')])[1]";
    public static final String NEW_DESIGN_BUTTON = "//div[@data-testid='new-design-file-button']";
    public static final String DRAFTS_BUTTON = "//span[text()='Drafts']";
    public static final String NEW_FIGJAMFILE_BUTTON = "//div[text()='New FigJam file']";


    //=====================================Design Page locators============================================
    public static final String CANVAS = "//canvas";
    public static final String SHAPE_TOOL_DROPDOWN = "//div[@data-testid=\"set-tool-rectangle\"]/div[@data-tooltip=\"Shape tools\"]";
    public static final String RECTANGLE_TOOL = "//a[@role=\"menuitem\"]/div[text()=\"Rectangle\"]";
    public static final String STAR_TOOL = "//a[@role=\"menuitem\"]/div[text()=\"Star\"]";
    public static final String FILE_NAME_ON_TOOLBAR = "//span[@data-testid=\"filename\"]";
    public static final String TITLE_BAR = "//div[@id=\"fullscreen-filename\"]";
    public static final String MAIN_MENU_DROPDOWN_BUTTON = "//button[@aria-label=\"Main menu\"]";
    public static final String BACK_TO_FILE_OPTION = "//div[@role=\"menuitem\"]/div[contains(text(),\"Back to files\")]";
    public static final String FILENAME_DROPDOWN_BUTTON = "//div[contains(@class,'filename_view--pageTitle')]//descendant::div[contains(@class,'chevron--chevronContainer')]";
    public static final String RENAME_BUTTON = "//div[@aria-label='Rename ']";
     public static final String FILENAME_TEXTBOX = "//input[@class='input--input--t9zdB filename_view--pageTitleInput--PyYW-']";
    public static final String FILENAME = "//span[@data-testid='filename']";
    public static final String TOOLS_MARKER = "(//div[@class='dlt_submenu--chevronButtonIcon--z4mp8'])[1]";
    public static final String DELETE_BUTTON = "//div[@aria-label='Delete… ']";
    public static final String SUBMIT_DELETE_BUTTON = "//button[@type='submit']";
    public static final String DELETE_POPUP = "//span[@data-testid='visual-bell-message']";
    public static final String SHARE_BUTTON = "//button[@data-button-type='share']";
    public static final String SHARE_ACCESS_DROPDOWN = "//span[@class='token_form--selectSpan--FhFz0']";
    public static final String SHARE_ACCESS_OPTIONS = "(//a[@role='menuitem'])[2]";
    public static final String SHARE_INPUT_EMAIL = "//input[@type='text']";
    public static final String SHARE_SEND_INVITE = "//button[@type='submit']";
    public static final String SHARED_EMAIL_FIELD = "(//div[@class='role_row--roleRow--ahvKW'])[3]";
    public static final String DROPDOWN_BUTON = "//div[@data-testid='filename-menu-chevron']";
    public static final String TEAMS = "//div[contains(@class,'teamTitleText')]";
    public static final String PROJECTS_IN_TEAMS = "//div[contains(@class,'teamTitleText')]//following::span[contains(@class,'folderName')]";
    public static final String MOVE_BUTTON = "//button[text()='Move']";
    public static final String DRAFT_FILES = "(//div[contains(@class,'tiles_view')and contains(@class,'tilesGrid')])[3]//div[contains(@class,'lowerPartTitles')]//div[contains(@class,'fontBase')and@data-tooltip-type=\"text\"]";
    public static final String SHAPES_TOOL_FIGJAMFILE = "(//div[contains(@class,'delightfulToolbarInner')]//div[contains(@class,'toolbarSection')])[1]/div[2]";
    public static final String CHANGE_SHAPE_MENU_FIGJAMFILE = "//div[contains(@class,'menu--root')]//div[contains(@aria-label,'Change shape')]";
    public static final String ROUNDED_RECTANGLE_SHAPE_FIGJAMFILE = "//div[@aria-label='rounded rectangle']";
    public static final String CHANGE_COLOUR_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Change color')]";
    public static final String YELLOW_COLOUR_FIGJAMFILE = "//div[contains(@aria-label,'Yellow')]";
    public static final String CHANGE_LINESTYLE_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Line style')]";
    public static final String DASHED_LINESTYLE_FIGJAMFILE = "//div[contains(@aria-label,'Dashed')]";
    public static final String CHANGE_TYPEFACE_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Typeface')]";
    public static final String BOOKISH_TYPEFACE_FIGJAMFILE = "//div[contains(@aria-label,'Bookish')]";
    public static final String CHANGE_FONT_SIZE_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Font size')]";
    public static final String MEDIUM_SIZE_FONT_FIGJAMFILE = "(//span[contains(@class,'select--optionText')and text()='Medium'])[2]";
    public static final String BOLD_FONT_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Bold')]";
    public static final String STRIKETHROUGH_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Strikethrough')]";
    public static final String CREATE_LINK_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Create link')]";
    public static final String ENTER_LINK_FIGJAMFILE = "//input[contains(@class,'hyperlink_editor')]";
    public static final String BULLETED_LIST_MENU_FIGJAMFILE = "//div[@aria-label='Bulleted list']";
    public static final String TEXT_ALIGNMENT_MENU_FIGJAMFILE = "//div[contains(@aria-label,'Text alignment')and@role='combobox']";
    public static final String TEXT_ALIGN_LEFT_FIGJAMFILE = "//div[@aria-label='Text align left']";
    public static final String COMMENT_BUTTON_FIGJAMFILE ="//span[@aria-label='Add comment']";
    public static final String COMMENT_TEXTBOX_FIGJAMFILE="//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr' ]";
    public static final String COMMENT_SUBMIT_FIGJAMFILE="//span[@aria-label='Submit']";
    public static final String COMMENT_VERIFY_FIGJAMFIME="//div[@data-testid='comment-message']";


    //=====================================Project Page locators============================================
    public static final String PROJECT_NAME_TEXT = "//h1[contains(@class,'css_builder')]";
    public static final String PROJECT_TAB = "//span[text()='Projects']";
    public static final String TEAMPROJECT_TAB = "//div[contains(@class,'folder_list_view--foldersContainer')]//descendant::div[text()='Team project']";

    //=====================================Team Project Page locators============================================
    public static final String NEW_FIGJAM_FILE = "(//div[@class='new_file_creation_topbar--tileText--sU7kJ'])[2]";



}
