using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Instructor
    {

        [Key]
        [Display(Name = "Instructor ID")]
        public int instructorID { get; set; }


        [Required(ErrorMessage = "Es requerido.")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [Display(Name = "Número de documento")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("Instructor_documentNumber_Index", IsUnique = true)]
        public String documentNumber { get; set; }


        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Primer nombre")]
        public String firstName { get; set; }

        [NotMapped]
        public String fullName { get { return string.Format("{0}  {1}, {2}, {3} ", firstName, surname, documentNumber, email); } }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Primer nombre")]
        public String toUpper2
        {
            get
            {
                if (firstName != null)
                {
                    firstName = firstName.ToUpper();
                }
                else
                {
                    firstName = "Es requerido.";
                }
                return firstName;
            }
            set
            {
                if (firstName != null)
                {
                    firstName = firstName.ToUpper();
                }
                else
                {
                    firstName = "Es requerido.";
                }
                firstName.ToUpper();
            }
        }

  
        [Display(Name = "Segundo nombre")]
        public String secondName { get; set; }

        
        [Display(Name = "Segundo nombre")]
        public String toUpper3
        {
            get
            {
                if (secondName != null)
                {
                    secondName = secondName.ToUpper();
                }
                else
                {
                    secondName = "";
                }
                return secondName;
            }
            set
            {
                if (secondName != null)
                {
                    secondName = secondName.ToUpper();
                }
                else
                {
                    secondName = "";
                }
                secondName.ToUpper();
            }
        }



        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Primer apellido")]
        public String surname { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Primer apellido")]
        public String toUpper4
        {
            get
            {
                if (surname != null)
                {
                    surname = surname.ToUpper();
                }
                else
                {
                    surname = "Es requerido.";
                }
                return surname;
            }
            set
            {
                if (surname != null)
                {
                    surname = surname.ToUpper();
                }
                else
                {
                    surname = "Es requerido.";
                }
                surname.ToUpper();
            }
        }


        [Display(Name = "Segundo apellido")]
        public String secondSurname { get; set; }

        
        [Display(Name = "Segundo apellido")]
        public String toUpper5
        {
            get
            {
                if (secondSurname != null)
                {
                    secondSurname = secondSurname.ToUpper();
                }
                else
                {
                    secondSurname = "";
                }
                return secondSurname;
            }
            set
            {
                if (secondSurname != null)
                {
                    secondSurname = secondSurname.ToUpper();
                }
                else
                {
                    secondSurname = "";
                }
                secondSurname.ToUpper();
            }
        }


        [DataType(DataType.EmailAddress)]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Correo")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("Instructor_email_Index", IsUnique = true)]
        public String email { get; set; }

        
        [DataType(DataType.ImageUrl)]
        public string photo { get; set; }
        [NotMapped]
        public HttpPostedFileBase PhotoFile { get; set; }

        public int idEmploymentRelationship { get; set; }
        public virtual EmploymentRelationship employment { get; set; }

        public int idSpeciality { get; set; }
        public virtual Speciality speciality { get; set; }

        public int documentID { get; set; }
        public virtual Document document { get; set; }

        public virtual ICollection<Disponibility> disponibility { get; set; }

        public virtual ICollection<Schedule> shedule { get; set; }

    }
}