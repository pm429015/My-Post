set -v
keytool -genkeypair -alias mykey -keyalg RSA -keysize 1024 -storetype jceks -validity 365 -keypass 776f3641548764e254ee292fc49af640 -keystore ppkeystore.jck -storepass 776f3641548764e254ee292fc49af640 -dname "cn=localhost, ou=Verisign, o=MSS Inc, l=Lexington, st=Kentucky, c=US"

keytool -export -alias mykey -storetype jceks -keystore ppkeystore.jck -storepass 776f3641548764e254ee292fc49af640 -file mykey.crt
#Certificate stored in file <mykey.crt>

keytool -importcert -alias mykey -file mykey.crt -keystore pptruststore.jck -keypass 776f3641548764e254ee292fc49af640 -storepass 776f3641548764e254ee292fc49af640
#Owner: CN=localhost, OU=Verisign, O=MSS Inc, L=Lexington, ST=Kentucky, C=US
#Issuer: CN=localhost, OU=Verisign, O=MSS Inc, L=Lexington, ST=Kentucky, C=US
#Serial number: d4255dd
#Valid from: Thu May 08 07:46:39 EDT 2014 until: Fri May 08 07:46:39 EDT 2015
#Certificate fingerprints:
#         MD5:  CF:69:9D:CA:D1:18:87:2B:95:8F:0D:0C:5A:15:88:DE
#         SHA1: 17:14:9F:76:F6:18:00:D1:0D:33:85:CF:56:0F:06:2D:03:F6:E8:23
#         SHA256: AE:A6:CD:9C:C0:DD:85:52:39:87:45:BD:0F:DB:2F:2F:B0:E1:3A:CF:1B:ED:2B:CC:6A:B4:35:A5:4E:AB:00:4F
#         Signature algorithm name: SHA256withRSA
#         Version: 3
#
#Extensions:

#1: ObjectId: 2.5.29.14 Criticality=false
#SubjectKeyIdentifier [
#KeyIdentifier [
#0000: CA 76 F9 A7 FD 1F B8 04   7B D8 3F A2 23 27 67 C4  .v........?.#'g.
#0010: E5 8D 40 62                                        ..@b
#]
#]
#
#Trust this certificate? [no]:  yes
#Certificate was added to keystore

