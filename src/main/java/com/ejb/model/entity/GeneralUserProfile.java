/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "general_user_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralUserProfile.findAll", query = "SELECT g FROM GeneralUserProfile g")
    , @NamedQuery(name = "GeneralUserProfile.findById", query = "SELECT g FROM GeneralUserProfile g WHERE g.id = :id")
    , @NamedQuery(name = "GeneralUserProfile.findByNic", query = "SELECT g FROM GeneralUserProfile g WHERE g.nic = :nic")
    , @NamedQuery(name = "GeneralUserProfile.findByChildNo", query = "SELECT g FROM GeneralUserProfile g WHERE g.childNo = :childNo")
    , @NamedQuery(name = "GeneralUserProfile.findByTitle", query = "SELECT g FROM GeneralUserProfile g WHERE g.title = :title")
    , @NamedQuery(name = "GeneralUserProfile.findByMidName", query = "SELECT g FROM GeneralUserProfile g WHERE g.midName = :midName")
    , @NamedQuery(name = "GeneralUserProfile.findByAddress1", query = "SELECT g FROM GeneralUserProfile g WHERE g.address1 = :address1")
    , @NamedQuery(name = "GeneralUserProfile.findByAddress2", query = "SELECT g FROM GeneralUserProfile g WHERE g.address2 = :address2")
    , @NamedQuery(name = "GeneralUserProfile.findByAddress3", query = "SELECT g FROM GeneralUserProfile g WHERE g.address3 = :address3")
    , @NamedQuery(name = "GeneralUserProfile.findByGender", query = "SELECT g FROM GeneralUserProfile g WHERE g.gender = :gender")
    , @NamedQuery(name = "GeneralUserProfile.findByCompany", query = "SELECT g FROM GeneralUserProfile g WHERE g.company = :company")
    , @NamedQuery(name = "GeneralUserProfile.findByDob", query = "SELECT g FROM GeneralUserProfile g WHERE g.dob = :dob")
    , @NamedQuery(name = "GeneralUserProfile.findByOfficePhone", query = "SELECT g FROM GeneralUserProfile g WHERE g.officePhone = :officePhone")
    , @NamedQuery(name = "GeneralUserProfile.findByHomePhone", query = "SELECT g FROM GeneralUserProfile g WHERE g.homePhone = :homePhone")
    , @NamedQuery(name = "GeneralUserProfile.findByMobilePhone", query = "SELECT g FROM GeneralUserProfile g WHERE g.mobilePhone = :mobilePhone")
    , @NamedQuery(name = "GeneralUserProfile.findByIp", query = "SELECT g FROM GeneralUserProfile g WHERE g.ip = :ip")
    , @NamedQuery(name = "GeneralUserProfile.findByImg", query = "SELECT g FROM GeneralUserProfile g WHERE g.img = :img")
    , @NamedQuery(name = "GeneralUserProfile.findByProfileCreatedDate", query = "SELECT g FROM GeneralUserProfile g WHERE g.profileCreatedDate = :profileCreatedDate")
    , @NamedQuery(name = "GeneralUserProfile.findByIsActive", query = "SELECT g FROM GeneralUserProfile g WHERE g.isActive = :isActive")
    , @NamedQuery(name = "GeneralUserProfile.findByFirstName", query = "SELECT g FROM GeneralUserProfile g WHERE g.firstName = :firstName")
    , @NamedQuery(name = "GeneralUserProfile.findByLastName", query = "SELECT g FROM GeneralUserProfile g WHERE g.lastName = :lastName")
    , @NamedQuery(name = "GeneralUserProfile.findByFullName", query = "SELECT g FROM GeneralUserProfile g WHERE g.fullName = :fullName")
    , @NamedQuery(name = "GeneralUserProfile.findByKnownName", query = "SELECT g FROM GeneralUserProfile g WHERE g.knownName = :knownName")
    , @NamedQuery(name = "GeneralUserProfile.findByEmail", query = "SELECT g FROM GeneralUserProfile g WHERE g.email = :email")
    , @NamedQuery(name = "GeneralUserProfile.findByNameWithIn", query = "SELECT g FROM GeneralUserProfile g WHERE g.nameWithIn = :nameWithIn")
    , @NamedQuery(name = "GeneralUserProfile.findByLicenseNo", query = "SELECT g FROM GeneralUserProfile g WHERE g.licenseNo = :licenseNo")
    , @NamedQuery(name = "GeneralUserProfile.findBySkype", query = "SELECT g FROM GeneralUserProfile g WHERE g.skype = :skype")
    , @NamedQuery(name = "GeneralUserProfile.findBySignature", query = "SELECT g FROM GeneralUserProfile g WHERE g.signature = :signature")
    , @NamedQuery(name = "GeneralUserProfile.findByIsMailSubscribed", query = "SELECT g FROM GeneralUserProfile g WHERE g.isMailSubscribed = :isMailSubscribed")
    , @NamedQuery(name = "GeneralUserProfile.findByIsSmsSubscribed", query = "SELECT g FROM GeneralUserProfile g WHERE g.isSmsSubscribed = :isSmsSubscribed")
    , @NamedQuery(name = "GeneralUserProfile.findByOccupationIdO", query = "SELECT g FROM GeneralUserProfile g WHERE g.occupationIdO = :occupationIdO")
    , @NamedQuery(name = "GeneralUserProfile.findByPostNorminals", query = "SELECT g FROM GeneralUserProfile g WHERE g.postNorminals = :postNorminals")})
public class GeneralUserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nic")
    private String nic;
    @Column(name = "child_no")
    private Integer childNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "mid_name")
    private String midName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address3")
    private String address3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "company")
    private String company;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 255)
    @Column(name = "office_phone")
    private String officePhone;
    @Size(max = 255)
    @Column(name = "home_phone")
    private String homePhone;
    @Size(max = 255)
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Size(max = 255)
    @Column(name = "ip")
    private String ip;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Lob
    @Size(max = 65535)
    @Column(name = "about_me")
    private String aboutMe;
    @Column(name = "profile_created_date")
    @Temporal(TemporalType.DATE)
    private Date profileCreatedDate;
    @Column(name = "is_active")
    private Integer isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 150)
    @Column(name = "full_name")
    private String fullName;
    @Size(max = 150)
    @Column(name = "known_name")
    private String knownName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 450)
    @Column(name = "name_with_in")
    private String nameWithIn;
    @Lob
    @Size(max = 65535)
    @Column(name = "family_background")
    private String familyBackground;
    @Size(max = 45)
    @Column(name = "license_no")
    private String licenseNo;
    @Size(max = 45)
    @Column(name = "skype")
    private String skype;
    @Size(max = 145)
    @Column(name = "signature")
    private String signature;
    @Column(name = "is_mail_subscribed")
    private Integer isMailSubscribed;
    @Column(name = "is_sms_subscribed")
    private Integer isSmsSubscribed;
    @Column(name = "occupation_id_o")
    private Integer occupationIdO;
    @Size(max = 255)
    @Column(name = "post_norminals")
    private String postNorminals;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<GupAlStream> gupAlStreamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkedBy")
    private Collection<UncommonDispatchNote> uncommonDispatchNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dispatchedBy")
    private Collection<UncommonDispatchNote> uncommonDispatchNoteCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<FingerPrintUser> fingerPrintUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUser")
    private Collection<ContactPerson> contactPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactPerson")
    private Collection<ContactPerson> contactPersonCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestedBy")
    private Collection<ComItemRequest> comItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notifiedBy")
    private Collection<NotificationController> notificationControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<Voucher> voucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<Post> postCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<WelfarePayments> welfarePaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<WelfareManager> welfareManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<DesignationLevelUserManager> designationLevelUserManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<ReceivedCheques> receivedChequesCollection;
    @JoinColumn(name = "languages_id", referencedColumnName = "id")
    @ManyToOne
    private Languages languagesId;
    @JoinColumn(name = "civil_status_id", referencedColumnName = "id")
    @ManyToOne
    private CivilStatus civilStatusId;
    @JoinColumn(name = "country_id_c", referencedColumnName = "id")
    @ManyToOne
    private Country countryIdC;
    @JoinColumn(name = "education_level_id", referencedColumnName = "id")
    @ManyToOne
    private EducationLevel educationLevelId;
    @JoinColumn(name = "employeement_status_id", referencedColumnName = "id")
    @ManyToOne
    private EmployeementStatus employeementStatusId;
    @JoinColumn(name = "general_organization_profile_id_gop", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileIdGop;
    @OneToMany(mappedBy = "generalUserProfileGupId")
    private Collection<GeneralUserProfile> generalUserProfileCollection;
    @JoinColumn(name = "general_user_profile_gup_id", referencedColumnName = "id")
    @ManyToOne
    private GeneralUserProfile generalUserProfileGupId;
    @JoinColumn(name = "industry_id", referencedColumnName = "id")
    @ManyToOne
    private Industry industryId;
    @JoinColumn(name = "political_views_id", referencedColumnName = "id")
    @ManyToOne
    private PoliticalViews politicalViewsId;
    @JoinColumn(name = "profession_id", referencedColumnName = "id")
    @ManyToOne
    private Profession professionId;
    @JoinColumn(name = "religion_id", referencedColumnName = "id")
    @ManyToOne
    private Religion religionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<UserImages> userImagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<VehicleUserManager> vehicleUserManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packedBy")
    private Collection<ItemPackaging> itemPackagingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver")
    private Collection<ComPostController> comPostControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driveBy")
    private Collection<VehicleInsuranceClame> vehicleInsuranceClameCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<LeaveRequestManager> leaveRequestManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appliedBy")
    private Collection<LoanMaster> loanMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uploadedBy")
    private Collection<UserDocument> userDocumentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<UserDocument> userDocumentCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<GupGopManager> gupGopManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<MagazeneSubscriber> magazeneSubscriberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<Employee> employeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<FamilyMembers> familyMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyMember")
    private Collection<FamilyMembers> familyMembersCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileIdFather")
    private Collection<SocialMediaFamilyNetwork> socialMediaFamilyNetworkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileIdMother")
    private Collection<SocialMediaFamilyNetwork> socialMediaFamilyNetworkCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileIdChild")
    private Collection<SocialMediaFamilyNetwork> socialMediaFamilyNetworkCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<OtherIncome> otherIncomeCollection;
    @OneToMany(mappedBy = "generalUserProfileId")
    private Collection<SerialNo> serialNoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileGupId")
    private Collection<GupSports> gupSportsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editor")
    private Collection<Story> storyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<DocumentMaster> documentMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acceptedBy")
    private Collection<DeliveryAcceptanceNote> deliveryAcceptanceNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<OrderMaster> orderMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<SupplierAdvanceRequestApproval> supplierAdvanceRequestApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<PersonCoaManager> personCoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<StoryReader> storyReaderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<UniversalFamilyMemberDetails> universalFamilyMemberDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId1")
    private Collection<UniversalFamilyMemberDetails> universalFamilyMemberDetailsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attention")
    private Collection<Quotation> quotationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<FamilyMemberDetails> familyMemberDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<WelfareCommitteeMembers> welfareCommitteeMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<CashSettlementHistory> cashSettlementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId1")
    private Collection<CashSettlementHistory> cashSettlementHistoryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<UserLogin> userLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<GupTypeManager> gupTypeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<SupplierRegistration> supplierRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<HelpTicket> helpTicketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<SocialMediaProfilePage> socialMediaProfilePageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<GupProperty> gupPropertyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<GupHobbies> gupHobbiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<NotificationActionController> notificationActionControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<CounsellingHistory> counsellingHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradingOfficer")
    private Collection<ItemGrading> itemGradingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inkedBy")
    private Collection<ItemGrading> itemGradingCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incharge")
    private Collection<ItemGrading> itemGradingCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<StatusChangedBy> statusChangedByCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<LoanGuarantor> loanGuarantorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    private Collection<ComPost> comPostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<PostReport> postReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<BankCustomerTransactionHistory> bankCustomerTransactionHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<HelpTicketReply> helpTicketReplyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<TransactionManagement> transactionManagementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<QualificationManager> qualificationManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<SchoolsAttended> schoolsAttendedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUserProfileId")
    private Collection<Interaction> interactionCollection;

    public GeneralUserProfile() {
    }

    public GeneralUserProfile(Integer id) {
        this.id = id;
    }

    public GeneralUserProfile(Integer id, String title, String address1, String address2, String address3, String gender, String firstName, String lastName) {
        this.id = id;
        this.title = title;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Integer getChildNo() {
        return childNo;
    }

    public void setChildNo(Integer childNo) {
        this.childNo = childNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Date getProfileCreatedDate() {
        return profileCreatedDate;
    }

    public void setProfileCreatedDate(Date profileCreatedDate) {
        this.profileCreatedDate = profileCreatedDate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKnownName() {
        return knownName;
    }

    public void setKnownName(String knownName) {
        this.knownName = knownName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameWithIn() {
        return nameWithIn;
    }

    public void setNameWithIn(String nameWithIn) {
        this.nameWithIn = nameWithIn;
    }

    public String getFamilyBackground() {
        return familyBackground;
    }

    public void setFamilyBackground(String familyBackground) {
        this.familyBackground = familyBackground;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getIsMailSubscribed() {
        return isMailSubscribed;
    }

    public void setIsMailSubscribed(Integer isMailSubscribed) {
        this.isMailSubscribed = isMailSubscribed;
    }

    public Integer getIsSmsSubscribed() {
        return isSmsSubscribed;
    }

    public void setIsSmsSubscribed(Integer isSmsSubscribed) {
        this.isSmsSubscribed = isSmsSubscribed;
    }

    public Integer getOccupationIdO() {
        return occupationIdO;
    }

    public void setOccupationIdO(Integer occupationIdO) {
        this.occupationIdO = occupationIdO;
    }

    public String getPostNorminals() {
        return postNorminals;
    }

    public void setPostNorminals(String postNorminals) {
        this.postNorminals = postNorminals;
    }

    @XmlTransient
    public Collection<GupAlStream> getGupAlStreamCollection() {
        return gupAlStreamCollection;
    }

    public void setGupAlStreamCollection(Collection<GupAlStream> gupAlStreamCollection) {
        this.gupAlStreamCollection = gupAlStreamCollection;
    }

    @XmlTransient
    public Collection<UncommonDispatchNote> getUncommonDispatchNoteCollection() {
        return uncommonDispatchNoteCollection;
    }

    public void setUncommonDispatchNoteCollection(Collection<UncommonDispatchNote> uncommonDispatchNoteCollection) {
        this.uncommonDispatchNoteCollection = uncommonDispatchNoteCollection;
    }

    @XmlTransient
    public Collection<UncommonDispatchNote> getUncommonDispatchNoteCollection1() {
        return uncommonDispatchNoteCollection1;
    }

    public void setUncommonDispatchNoteCollection1(Collection<UncommonDispatchNote> uncommonDispatchNoteCollection1) {
        this.uncommonDispatchNoteCollection1 = uncommonDispatchNoteCollection1;
    }

    @XmlTransient
    public Collection<FingerPrintUser> getFingerPrintUserCollection() {
        return fingerPrintUserCollection;
    }

    public void setFingerPrintUserCollection(Collection<FingerPrintUser> fingerPrintUserCollection) {
        this.fingerPrintUserCollection = fingerPrintUserCollection;
    }

    @XmlTransient
    public Collection<ContactPerson> getContactPersonCollection() {
        return contactPersonCollection;
    }

    public void setContactPersonCollection(Collection<ContactPerson> contactPersonCollection) {
        this.contactPersonCollection = contactPersonCollection;
    }

    @XmlTransient
    public Collection<ContactPerson> getContactPersonCollection1() {
        return contactPersonCollection1;
    }

    public void setContactPersonCollection1(Collection<ContactPerson> contactPersonCollection1) {
        this.contactPersonCollection1 = contactPersonCollection1;
    }

    @XmlTransient
    public Collection<ComItemRequest> getComItemRequestCollection() {
        return comItemRequestCollection;
    }

    public void setComItemRequestCollection(Collection<ComItemRequest> comItemRequestCollection) {
        this.comItemRequestCollection = comItemRequestCollection;
    }

    @XmlTransient
    public Collection<NotificationController> getNotificationControllerCollection() {
        return notificationControllerCollection;
    }

    public void setNotificationControllerCollection(Collection<NotificationController> notificationControllerCollection) {
        this.notificationControllerCollection = notificationControllerCollection;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    @XmlTransient
    public Collection<WelfarePayments> getWelfarePaymentsCollection() {
        return welfarePaymentsCollection;
    }

    public void setWelfarePaymentsCollection(Collection<WelfarePayments> welfarePaymentsCollection) {
        this.welfarePaymentsCollection = welfarePaymentsCollection;
    }

    @XmlTransient
    public Collection<WelfareManager> getWelfareManagerCollection() {
        return welfareManagerCollection;
    }

    public void setWelfareManagerCollection(Collection<WelfareManager> welfareManagerCollection) {
        this.welfareManagerCollection = welfareManagerCollection;
    }

    @XmlTransient
    public Collection<DesignationLevelUserManager> getDesignationLevelUserManagerCollection() {
        return designationLevelUserManagerCollection;
    }

    public void setDesignationLevelUserManagerCollection(Collection<DesignationLevelUserManager> designationLevelUserManagerCollection) {
        this.designationLevelUserManagerCollection = designationLevelUserManagerCollection;
    }

    @XmlTransient
    public Collection<ReceivedCheques> getReceivedChequesCollection() {
        return receivedChequesCollection;
    }

    public void setReceivedChequesCollection(Collection<ReceivedCheques> receivedChequesCollection) {
        this.receivedChequesCollection = receivedChequesCollection;
    }

    public Languages getLanguagesId() {
        return languagesId;
    }

    public void setLanguagesId(Languages languagesId) {
        this.languagesId = languagesId;
    }

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public Country getCountryIdC() {
        return countryIdC;
    }

    public void setCountryIdC(Country countryIdC) {
        this.countryIdC = countryIdC;
    }

    public EducationLevel getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(EducationLevel educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public EmployeementStatus getEmployeementStatusId() {
        return employeementStatusId;
    }

    public void setEmployeementStatusId(EmployeementStatus employeementStatusId) {
        this.employeementStatusId = employeementStatusId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileIdGop() {
        return generalOrganizationProfileIdGop;
    }

    public void setGeneralOrganizationProfileIdGop(GeneralOrganizationProfile generalOrganizationProfileIdGop) {
        this.generalOrganizationProfileIdGop = generalOrganizationProfileIdGop;
    }

    @XmlTransient
    public Collection<GeneralUserProfile> getGeneralUserProfileCollection() {
        return generalUserProfileCollection;
    }

    public void setGeneralUserProfileCollection(Collection<GeneralUserProfile> generalUserProfileCollection) {
        this.generalUserProfileCollection = generalUserProfileCollection;
    }

    public GeneralUserProfile getGeneralUserProfileGupId() {
        return generalUserProfileGupId;
    }

    public void setGeneralUserProfileGupId(GeneralUserProfile generalUserProfileGupId) {
        this.generalUserProfileGupId = generalUserProfileGupId;
    }

    public Industry getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Industry industryId) {
        this.industryId = industryId;
    }

    public PoliticalViews getPoliticalViewsId() {
        return politicalViewsId;
    }

    public void setPoliticalViewsId(PoliticalViews politicalViewsId) {
        this.politicalViewsId = politicalViewsId;
    }

    public Profession getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Profession professionId) {
        this.professionId = professionId;
    }

    public Religion getReligionId() {
        return religionId;
    }

    public void setReligionId(Religion religionId) {
        this.religionId = religionId;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequest> getUniversalBoughtleafItemRequestCollection() {
        return universalBoughtleafItemRequestCollection;
    }

    public void setUniversalBoughtleafItemRequestCollection(Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection) {
        this.universalBoughtleafItemRequestCollection = universalBoughtleafItemRequestCollection;
    }

    @XmlTransient
    public Collection<UserImages> getUserImagesCollection() {
        return userImagesCollection;
    }

    public void setUserImagesCollection(Collection<UserImages> userImagesCollection) {
        this.userImagesCollection = userImagesCollection;
    }

    @XmlTransient
    public Collection<VehicleUserManager> getVehicleUserManagerCollection() {
        return vehicleUserManagerCollection;
    }

    public void setVehicleUserManagerCollection(Collection<VehicleUserManager> vehicleUserManagerCollection) {
        this.vehicleUserManagerCollection = vehicleUserManagerCollection;
    }

    @XmlTransient
    public Collection<ItemPackaging> getItemPackagingCollection() {
        return itemPackagingCollection;
    }

    public void setItemPackagingCollection(Collection<ItemPackaging> itemPackagingCollection) {
        this.itemPackagingCollection = itemPackagingCollection;
    }

    @XmlTransient
    public Collection<ComPostController> getComPostControllerCollection() {
        return comPostControllerCollection;
    }

    public void setComPostControllerCollection(Collection<ComPostController> comPostControllerCollection) {
        this.comPostControllerCollection = comPostControllerCollection;
    }

    @XmlTransient
    public Collection<VehicleInsuranceClame> getVehicleInsuranceClameCollection() {
        return vehicleInsuranceClameCollection;
    }

    public void setVehicleInsuranceClameCollection(Collection<VehicleInsuranceClame> vehicleInsuranceClameCollection) {
        this.vehicleInsuranceClameCollection = vehicleInsuranceClameCollection;
    }

    @XmlTransient
    public Collection<LeaveRequestManager> getLeaveRequestManagerCollection() {
        return leaveRequestManagerCollection;
    }

    public void setLeaveRequestManagerCollection(Collection<LeaveRequestManager> leaveRequestManagerCollection) {
        this.leaveRequestManagerCollection = leaveRequestManagerCollection;
    }

    @XmlTransient
    public Collection<LoanMaster> getLoanMasterCollection() {
        return loanMasterCollection;
    }

    public void setLoanMasterCollection(Collection<LoanMaster> loanMasterCollection) {
        this.loanMasterCollection = loanMasterCollection;
    }

    @XmlTransient
    public Collection<UserDocument> getUserDocumentCollection() {
        return userDocumentCollection;
    }

    public void setUserDocumentCollection(Collection<UserDocument> userDocumentCollection) {
        this.userDocumentCollection = userDocumentCollection;
    }

    @XmlTransient
    public Collection<UserDocument> getUserDocumentCollection1() {
        return userDocumentCollection1;
    }

    public void setUserDocumentCollection1(Collection<UserDocument> userDocumentCollection1) {
        this.userDocumentCollection1 = userDocumentCollection1;
    }

    @XmlTransient
    public Collection<GupGopManager> getGupGopManagerCollection() {
        return gupGopManagerCollection;
    }

    public void setGupGopManagerCollection(Collection<GupGopManager> gupGopManagerCollection) {
        this.gupGopManagerCollection = gupGopManagerCollection;
    }

    @XmlTransient
    public Collection<MagazeneSubscriber> getMagazeneSubscriberCollection() {
        return magazeneSubscriberCollection;
    }

    public void setMagazeneSubscriberCollection(Collection<MagazeneSubscriber> magazeneSubscriberCollection) {
        this.magazeneSubscriberCollection = magazeneSubscriberCollection;
    }

    @XmlTransient
    public Collection<GeneralJournalEntry> getGeneralJournalEntryCollection() {
        return generalJournalEntryCollection;
    }

    public void setGeneralJournalEntryCollection(Collection<GeneralJournalEntry> generalJournalEntryCollection) {
        this.generalJournalEntryCollection = generalJournalEntryCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<FamilyMembers> getFamilyMembersCollection() {
        return familyMembersCollection;
    }

    public void setFamilyMembersCollection(Collection<FamilyMembers> familyMembersCollection) {
        this.familyMembersCollection = familyMembersCollection;
    }

    @XmlTransient
    public Collection<FamilyMembers> getFamilyMembersCollection1() {
        return familyMembersCollection1;
    }

    public void setFamilyMembersCollection1(Collection<FamilyMembers> familyMembersCollection1) {
        this.familyMembersCollection1 = familyMembersCollection1;
    }

    @XmlTransient
    public Collection<SocialMediaFamilyNetwork> getSocialMediaFamilyNetworkCollection() {
        return socialMediaFamilyNetworkCollection;
    }

    public void setSocialMediaFamilyNetworkCollection(Collection<SocialMediaFamilyNetwork> socialMediaFamilyNetworkCollection) {
        this.socialMediaFamilyNetworkCollection = socialMediaFamilyNetworkCollection;
    }

    @XmlTransient
    public Collection<SocialMediaFamilyNetwork> getSocialMediaFamilyNetworkCollection1() {
        return socialMediaFamilyNetworkCollection1;
    }

    public void setSocialMediaFamilyNetworkCollection1(Collection<SocialMediaFamilyNetwork> socialMediaFamilyNetworkCollection1) {
        this.socialMediaFamilyNetworkCollection1 = socialMediaFamilyNetworkCollection1;
    }

    @XmlTransient
    public Collection<SocialMediaFamilyNetwork> getSocialMediaFamilyNetworkCollection2() {
        return socialMediaFamilyNetworkCollection2;
    }

    public void setSocialMediaFamilyNetworkCollection2(Collection<SocialMediaFamilyNetwork> socialMediaFamilyNetworkCollection2) {
        this.socialMediaFamilyNetworkCollection2 = socialMediaFamilyNetworkCollection2;
    }

    @XmlTransient
    public Collection<OtherIncome> getOtherIncomeCollection() {
        return otherIncomeCollection;
    }

    public void setOtherIncomeCollection(Collection<OtherIncome> otherIncomeCollection) {
        this.otherIncomeCollection = otherIncomeCollection;
    }

    @XmlTransient
    public Collection<SerialNo> getSerialNoCollection() {
        return serialNoCollection;
    }

    public void setSerialNoCollection(Collection<SerialNo> serialNoCollection) {
        this.serialNoCollection = serialNoCollection;
    }

    @XmlTransient
    public Collection<GupSports> getGupSportsCollection() {
        return gupSportsCollection;
    }

    public void setGupSportsCollection(Collection<GupSports> gupSportsCollection) {
        this.gupSportsCollection = gupSportsCollection;
    }

    @XmlTransient
    public Collection<Story> getStoryCollection() {
        return storyCollection;
    }

    public void setStoryCollection(Collection<Story> storyCollection) {
        this.storyCollection = storyCollection;
    }

    @XmlTransient
    public Collection<DocumentMaster> getDocumentMasterCollection() {
        return documentMasterCollection;
    }

    public void setDocumentMasterCollection(Collection<DocumentMaster> documentMasterCollection) {
        this.documentMasterCollection = documentMasterCollection;
    }

    @XmlTransient
    public Collection<DeliveryAcceptanceNote> getDeliveryAcceptanceNoteCollection() {
        return deliveryAcceptanceNoteCollection;
    }

    public void setDeliveryAcceptanceNoteCollection(Collection<DeliveryAcceptanceNote> deliveryAcceptanceNoteCollection) {
        this.deliveryAcceptanceNoteCollection = deliveryAcceptanceNoteCollection;
    }

    @XmlTransient
    public Collection<OrderMaster> getOrderMasterCollection() {
        return orderMasterCollection;
    }

    public void setOrderMasterCollection(Collection<OrderMaster> orderMasterCollection) {
        this.orderMasterCollection = orderMasterCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequestApproval> getSupplierAdvanceRequestApprovalCollection() {
        return supplierAdvanceRequestApprovalCollection;
    }

    public void setSupplierAdvanceRequestApprovalCollection(Collection<SupplierAdvanceRequestApproval> supplierAdvanceRequestApprovalCollection) {
        this.supplierAdvanceRequestApprovalCollection = supplierAdvanceRequestApprovalCollection;
    }

    @XmlTransient
    public Collection<PersonCoaManager> getPersonCoaManagerCollection() {
        return personCoaManagerCollection;
    }

    public void setPersonCoaManagerCollection(Collection<PersonCoaManager> personCoaManagerCollection) {
        this.personCoaManagerCollection = personCoaManagerCollection;
    }

    @XmlTransient
    public Collection<StoryReader> getStoryReaderCollection() {
        return storyReaderCollection;
    }

    public void setStoryReaderCollection(Collection<StoryReader> storyReaderCollection) {
        this.storyReaderCollection = storyReaderCollection;
    }

    @XmlTransient
    public Collection<UniversalFamilyMemberDetails> getUniversalFamilyMemberDetailsCollection() {
        return universalFamilyMemberDetailsCollection;
    }

    public void setUniversalFamilyMemberDetailsCollection(Collection<UniversalFamilyMemberDetails> universalFamilyMemberDetailsCollection) {
        this.universalFamilyMemberDetailsCollection = universalFamilyMemberDetailsCollection;
    }

    @XmlTransient
    public Collection<UniversalFamilyMemberDetails> getUniversalFamilyMemberDetailsCollection1() {
        return universalFamilyMemberDetailsCollection1;
    }

    public void setUniversalFamilyMemberDetailsCollection1(Collection<UniversalFamilyMemberDetails> universalFamilyMemberDetailsCollection1) {
        this.universalFamilyMemberDetailsCollection1 = universalFamilyMemberDetailsCollection1;
    }

    @XmlTransient
    public Collection<Quotation> getQuotationCollection() {
        return quotationCollection;
    }

    public void setQuotationCollection(Collection<Quotation> quotationCollection) {
        this.quotationCollection = quotationCollection;
    }

    @XmlTransient
    public Collection<FamilyMemberDetails> getFamilyMemberDetailsCollection() {
        return familyMemberDetailsCollection;
    }

    public void setFamilyMemberDetailsCollection(Collection<FamilyMemberDetails> familyMemberDetailsCollection) {
        this.familyMemberDetailsCollection = familyMemberDetailsCollection;
    }

    @XmlTransient
    public Collection<WelfareCommitteeMembers> getWelfareCommitteeMembersCollection() {
        return welfareCommitteeMembersCollection;
    }

    public void setWelfareCommitteeMembersCollection(Collection<WelfareCommitteeMembers> welfareCommitteeMembersCollection) {
        this.welfareCommitteeMembersCollection = welfareCommitteeMembersCollection;
    }

    @XmlTransient
    public Collection<CashSettlementHistory> getCashSettlementHistoryCollection() {
        return cashSettlementHistoryCollection;
    }

    public void setCashSettlementHistoryCollection(Collection<CashSettlementHistory> cashSettlementHistoryCollection) {
        this.cashSettlementHistoryCollection = cashSettlementHistoryCollection;
    }

    @XmlTransient
    public Collection<CashSettlementHistory> getCashSettlementHistoryCollection1() {
        return cashSettlementHistoryCollection1;
    }

    public void setCashSettlementHistoryCollection1(Collection<CashSettlementHistory> cashSettlementHistoryCollection1) {
        this.cashSettlementHistoryCollection1 = cashSettlementHistoryCollection1;
    }

    @XmlTransient
    public Collection<UserLogin> getUserLoginCollection() {
        return userLoginCollection;
    }

    public void setUserLoginCollection(Collection<UserLogin> userLoginCollection) {
        this.userLoginCollection = userLoginCollection;
    }

    @XmlTransient
    public Collection<GupTypeManager> getGupTypeManagerCollection() {
        return gupTypeManagerCollection;
    }

    public void setGupTypeManagerCollection(Collection<GupTypeManager> gupTypeManagerCollection) {
        this.gupTypeManagerCollection = gupTypeManagerCollection;
    }

    @XmlTransient
    public Collection<SupplierRegistration> getSupplierRegistrationCollection() {
        return supplierRegistrationCollection;
    }

    public void setSupplierRegistrationCollection(Collection<SupplierRegistration> supplierRegistrationCollection) {
        this.supplierRegistrationCollection = supplierRegistrationCollection;
    }

    @XmlTransient
    public Collection<HelpTicket> getHelpTicketCollection() {
        return helpTicketCollection;
    }

    public void setHelpTicketCollection(Collection<HelpTicket> helpTicketCollection) {
        this.helpTicketCollection = helpTicketCollection;
    }

    @XmlTransient
    public Collection<SocialMediaProfilePage> getSocialMediaProfilePageCollection() {
        return socialMediaProfilePageCollection;
    }

    public void setSocialMediaProfilePageCollection(Collection<SocialMediaProfilePage> socialMediaProfilePageCollection) {
        this.socialMediaProfilePageCollection = socialMediaProfilePageCollection;
    }

    @XmlTransient
    public Collection<GupProperty> getGupPropertyCollection() {
        return gupPropertyCollection;
    }

    public void setGupPropertyCollection(Collection<GupProperty> gupPropertyCollection) {
        this.gupPropertyCollection = gupPropertyCollection;
    }

    @XmlTransient
    public Collection<GupHobbies> getGupHobbiesCollection() {
        return gupHobbiesCollection;
    }

    public void setGupHobbiesCollection(Collection<GupHobbies> gupHobbiesCollection) {
        this.gupHobbiesCollection = gupHobbiesCollection;
    }

    @XmlTransient
    public Collection<NotificationActionController> getNotificationActionControllerCollection() {
        return notificationActionControllerCollection;
    }

    public void setNotificationActionControllerCollection(Collection<NotificationActionController> notificationActionControllerCollection) {
        this.notificationActionControllerCollection = notificationActionControllerCollection;
    }

    @XmlTransient
    public Collection<CounsellingHistory> getCounsellingHistoryCollection() {
        return counsellingHistoryCollection;
    }

    public void setCounsellingHistoryCollection(Collection<CounsellingHistory> counsellingHistoryCollection) {
        this.counsellingHistoryCollection = counsellingHistoryCollection;
    }

    @XmlTransient
    public Collection<ItemGrading> getItemGradingCollection() {
        return itemGradingCollection;
    }

    public void setItemGradingCollection(Collection<ItemGrading> itemGradingCollection) {
        this.itemGradingCollection = itemGradingCollection;
    }

    @XmlTransient
    public Collection<ItemGrading> getItemGradingCollection1() {
        return itemGradingCollection1;
    }

    public void setItemGradingCollection1(Collection<ItemGrading> itemGradingCollection1) {
        this.itemGradingCollection1 = itemGradingCollection1;
    }

    @XmlTransient
    public Collection<ItemGrading> getItemGradingCollection2() {
        return itemGradingCollection2;
    }

    public void setItemGradingCollection2(Collection<ItemGrading> itemGradingCollection2) {
        this.itemGradingCollection2 = itemGradingCollection2;
    }

    @XmlTransient
    public Collection<StatusChangedBy> getStatusChangedByCollection() {
        return statusChangedByCollection;
    }

    public void setStatusChangedByCollection(Collection<StatusChangedBy> statusChangedByCollection) {
        this.statusChangedByCollection = statusChangedByCollection;
    }

    @XmlTransient
    public Collection<LoanGuarantor> getLoanGuarantorCollection() {
        return loanGuarantorCollection;
    }

    public void setLoanGuarantorCollection(Collection<LoanGuarantor> loanGuarantorCollection) {
        this.loanGuarantorCollection = loanGuarantorCollection;
    }

    @XmlTransient
    public Collection<ComPost> getComPostCollection() {
        return comPostCollection;
    }

    public void setComPostCollection(Collection<ComPost> comPostCollection) {
        this.comPostCollection = comPostCollection;
    }

    @XmlTransient
    public Collection<PostReport> getPostReportCollection() {
        return postReportCollection;
    }

    public void setPostReportCollection(Collection<PostReport> postReportCollection) {
        this.postReportCollection = postReportCollection;
    }

    @XmlTransient
    public Collection<BankCustomerTransactionHistory> getBankCustomerTransactionHistoryCollection() {
        return bankCustomerTransactionHistoryCollection;
    }

    public void setBankCustomerTransactionHistoryCollection(Collection<BankCustomerTransactionHistory> bankCustomerTransactionHistoryCollection) {
        this.bankCustomerTransactionHistoryCollection = bankCustomerTransactionHistoryCollection;
    }

    @XmlTransient
    public Collection<HelpTicketReply> getHelpTicketReplyCollection() {
        return helpTicketReplyCollection;
    }

    public void setHelpTicketReplyCollection(Collection<HelpTicketReply> helpTicketReplyCollection) {
        this.helpTicketReplyCollection = helpTicketReplyCollection;
    }

    @XmlTransient
    public Collection<TransactionManagement> getTransactionManagementCollection() {
        return transactionManagementCollection;
    }

    public void setTransactionManagementCollection(Collection<TransactionManagement> transactionManagementCollection) {
        this.transactionManagementCollection = transactionManagementCollection;
    }

    @XmlTransient
    public Collection<QualificationManager> getQualificationManagerCollection() {
        return qualificationManagerCollection;
    }

    public void setQualificationManagerCollection(Collection<QualificationManager> qualificationManagerCollection) {
        this.qualificationManagerCollection = qualificationManagerCollection;
    }

    @XmlTransient
    public Collection<SchoolsAttended> getSchoolsAttendedCollection() {
        return schoolsAttendedCollection;
    }

    public void setSchoolsAttendedCollection(Collection<SchoolsAttended> schoolsAttendedCollection) {
        this.schoolsAttendedCollection = schoolsAttendedCollection;
    }

    @XmlTransient
    public Collection<Interaction> getInteractionCollection() {
        return interactionCollection;
    }

    public void setInteractionCollection(Collection<Interaction> interactionCollection) {
        this.interactionCollection = interactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralUserProfile)) {
            return false;
        }
        GeneralUserProfile other = (GeneralUserProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GeneralUserProfile[ id=" + id + " ]";
    }
    
}
